<script setup>
import { onMounted, ref } from 'vue'
import { listarSolicitudes } from '../services/solicitudService'

const solicitudes = ref([])
const cargando = ref(true)
const error = ref('')

onMounted(async () => {
  try {
    solicitudes.value = await listarSolicitudes()
  } catch (err) {
    error.value = 'No fue posible cargar las solicitudes.'
    console.error(err)
  } finally {
    cargando.value = false
  }
})
</script>

<template>
  <section class="solicitudes-page">
    <div class="page-header">
      <div>
        <h1>Solicitudes</h1>
        <p>Consulta y administra las solicitudes registradas.</p>
      </div>

      <button class="primary-button">
        + Nueva solicitud
      </button>
    </div>

    <div class="content-card">
      <div class="card-header">
        <h2>Listado de solicitudes</h2>
      </div>

      <div v-if="cargando" class="message-state">
        Cargando solicitudes...
      </div>

      <div v-else-if="error" class="message-state error">
        {{ error }}
      </div>

      <div v-else-if="solicitudes.length === 0" class="empty-state">
        <h3>No hay solicitudes para mostrar</h3>
        <p>Cuando existan solicitudes registradas, aparecerán en este listado.</p>
      </div>

      <table v-else class="solicitudes-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Descripción</th>
            <th>Estado</th>
            <th>Fecha de generación</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="solicitud in solicitudes" :key="solicitud.id">
            <td>{{ solicitud.id }}</td>
            <td>{{ solicitud.descripcion }}</td>
            <td>{{ solicitud.estado }}</td>
            <td>{{ solicitud.fechaGeneracion }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>
</template>

<style scoped>
.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 25px;
}

h1 {
  font-size: 25px;
  font-weight: 600;
  margin-bottom: 5px;
}

.page-header p {
  color: #718096;
}

.primary-button {
  background: #3977c5;
  color: white;
  border: none;
  border-radius: 6px;
  padding: 11px 18px;
  cursor: pointer;
}

.content-card {
  background: white;
  border: 1px solid #e1e6ed;
  border-radius: 8px;
  overflow-x: auto;
}

.card-header {
  padding: 18px 22px;
  border-bottom: 1px solid #e1e6ed;
}

.card-header h2 {
  font-size: 16px;
  font-weight: 600;
}

.empty-state,
.message-state {
  padding: 40px 20px;
  text-align: center;
}

.empty-state h3 {
  font-size: 16px;
  margin-bottom: 8px;
}

.empty-state p {
  color: #718096;
}

.error {
  color: #b42318;
}

.solicitudes-table {
  width: 100%;
  border-collapse: collapse;
  text-align: left;
}

.solicitudes-table th,
.solicitudes-table td {
  padding: 14px 22px;
  border-bottom: 1px solid #e1e6ed;
}

.solicitudes-table th {
  color: #718096;
  font-weight: 600;
  background: #f8fafc;
}

.solicitudes-table tr:last-child td {
  border-bottom: none;
}
</style>