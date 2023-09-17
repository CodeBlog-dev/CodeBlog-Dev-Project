<script setup>
import editArticleComponent from '../../components/dashboard/EditArticleComponent.vue';
</script>
<template>
  <div class="container">
    <div class="content">
      <editArticleComponent/>
    </div>
  </div>
</template>

<style scoped>
.container {
  margin: 0 auto; /* Centra el contenido horizontalmente */
  max-width: 1200px; /* Establece el ancho máximo del contenedor */
  padding: 0 20px; /* Agrega distancia a los laterales */
}

.content {
  margin-top: 20px; /* Agrega distancia entre el contenido y el header */
  
}
</style>

