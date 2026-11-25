const API_URL = 'http://localhost:8080/solicitudes'

export async function listarSolicitudes() {
  const response = await fetch(API_URL)

  if (!response.ok) {
    throw new Error(`Error al consultar solicitudes: ${response.status}`)
  }

  return response.json()
}