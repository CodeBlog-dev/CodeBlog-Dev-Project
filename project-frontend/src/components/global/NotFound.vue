<template>
  <div class="error-container">
    <div class="error-content">
      <h1 class="error-title">404</h1>
      <p class="error-message">¡Ups! Parece que te has perdido en el camino.</p>
      <router-link to="/" class="back-home-link">Volver a la página de inicio</router-link>
    </div>
  </div>
</template>

<style scoped>
.error-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f0f0;
}

.error-content {
  text-align: center;
}

.error-title {
  font-size: 6rem;
  color: #f44336; /* Color rojo */
}

.error-message {
  font-size: 1.5rem;
  margin-top: 20px;
  color: #333;
}

.back-home-link {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #007bff; /* Color azul */
  color: #fff;
  text-decoration: none;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.back-home-link:hover {
  background-color: #0056b3; /* Color azul oscuro al pasar el mouse */
}
</style>
