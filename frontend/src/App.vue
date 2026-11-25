
<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div class="app-layout">
    <!-- Navegación lateral -->
    <aside class="sidebar">
      <div class="brand">
        <div class="brand-icon">S</div>
        <div class="brand-text">
          <h1>Solicitudes</h1>
          <span>Gestión de solicitudes</span>
        </div>
      </div>

      <nav class="navigation">
        <span class="nav-section">GENERAL</span>

        <RouterLink to="/solicitudes" class="nav-item">
          <span class="nav-icon">▤</span>
          <span>Solicitudes</span>
        </RouterLink>

        <span class="nav-section">GESTIÓN</span>

        <RouterLink to="/" class="nav-item">
          <span class="nav-icon">▤</span>
          <span>Solicitudes</span>
        </RouterLink>

        <a href="#" class="nav-item disabled">
          <span class="nav-icon">◷</span>
          <span>Mis solicitudes</span>
        </a>

        <a href="#" class="nav-item disabled">
          <span class="nav-icon">▣</span>
          <span>En revisión</span>
        </a>

        <span class="nav-section">ADMINISTRACIÓN</span>

        <a href="#" class="nav-item disabled">
          <span class="nav-icon">▥</span>
          <span>Auditoría</span>
        </a>
      </nav>

      <div class="sidebar-footer">
        <div class="user-avatar">U</div>
        <div class="user-info">
          <strong>Usuario</strong>
          <span>Sesión de trabajo</span>
        </div>
      </div>
    </aside>

    <!-- Área principal -->
    <div class="main-container">
      <header class="topbar">
        <div class="breadcrumb">Aplicación / <strong>Inicio</strong></div>
        <div class="topbar-status">Sistema de gestión</div>
      </header>

      <main class="content">
        <RouterView />
      </main>
    </div>
  </div>
</template>

<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  color: #263445;
  background: #f4f6f9;
}

.app-layout {
  display: flex;
  min-height: 100vh;
}

/* Sidebar */

.sidebar {
  width: 250px;
  min-height: 100vh;
  background: #17283f;
  color: #fff;
  display: flex;
  flex-direction: column;
  flex-shrink: 0;
}

.brand {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 25px 20px;
  border-bottom: 1px solid #304158;
}

.brand-icon {
  width: 38px;
  height: 38px;
  display: grid;
  place-items: center;
  background: #3977c5;
  border-radius: 8px;
  font-size: 20px;
  font-weight: bold;
}

.brand-text h1 {
  font-size: 17px;
  margin: 0 0 4px;
}

.brand-text span {
  font-size: 11px;
  color: #aab8ca;
}

.navigation {
  padding: 22px 12px;
  flex: 1;
}

.nav-section {
  display: block;
  padding: 16px 12px 8px;
  color: #899bb2;
  font-size: 10px;
  font-weight: bold;
  letter-spacing: 1px;
}

.nav-item {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 12px;
  margin-bottom: 4px;
  border-radius: 6px;
  color: #d1dbe7;
  text-decoration: none;
  font-size: 13px;
  transition: background 0.2s;
}

.nav-item:hover {
  background: #263d5a;
}

.nav-item.router-link-active {
  background: #2d5f9d;
  color: #fff;
}

.nav-icon {
  width: 20px;
  text-align: center;
  font-size: 18px;
}

.nav-item.disabled {
  opacity: 0.5;
  cursor: default;
}

.sidebar-footer {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 18px;
  border-top: 1px solid #304158;
}

.user-avatar {
  width: 35px;
  height: 35px;
  display: grid;
  place-items: center;
  border-radius: 50%;
  background: #3977c5;
  font-weight: bold;
}

.user-info {
  display: flex;
  flex-direction: column;
  gap: 4px;
  font-size: 12px;
}

.user-info span {
  color: #aab8ca;
  font-size: 10px;
}

/* Área principal */

.main-container {
  flex: 1;
  min-width: 0;
}

.topbar {
  height: 65px;
  background: #fff;
  border-bottom: 1px solid #e1e6ed;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 30px;
}

.breadcrumb {
  color: #8995a5;
  font-size: 13px;
}

.breadcrumb strong {
  color: #263445;
}

.topbar-status {
  font-size: 12px;
  color: #64748b;
}

.content {
  padding: 30px;
}

/* Adaptación a pantallas pequeñas */

@media (max-width: 700px) {
  .sidebar {
    width: 70px;
  }

  .brand {
    justify-content: center;
    padding: 20px 5px;
  }

  .brand-text,
  .nav-section,
  .nav-item span:not(.nav-icon),
  .user-info {
    display: none;
  }

  .nav-item {
    justify-content: center;
    padding: 14px 5px;
  }

  .sidebar-footer {
    justify-content: center;
    padding: 15px 5px;
  }

  .content {
    padding: 18px;
  }
}
</style>
