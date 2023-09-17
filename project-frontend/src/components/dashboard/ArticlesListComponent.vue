
<script setup>
import { ref, onMounted } from "vue";
import api from "../../lib/axios.js";

const articles = ref([]);
const isLoading = ref(true);
const isError = ref(false);
let errorMessage = ref("");
const showSuccessMessage = ref(false);

// Called when the component is mounted (ready to be used)
onMounted(async () => {
  try {
    const response = await getArticles();
    articles.value = response.data;
    isLoading.value = false;
    showSuccessMessage.value = true;
  } catch (error) {
    errorMessage = error.message;
    isError.value = true;
  }
});

// Get articles from backend
const getArticles = async () => {
  try {
    const response = await api.get("/articles");
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error("Error al obtener los artículos");
  }
};

// Rediect to edit article page
const editArticle = (article) => {
  window.location.href = `/dashboard/articles/${article.id}`;
};

// Redirect to create article page
const nuevaPublicacion = () => {
  window.location.href = "/dashboard/articles/new";
};

// Delete article
const deleteArticle = async (articleId) => {
  try {
    await api.delete(`/articles/${articleId}`);
    window.location.reload();
  } catch (error) {
    console.error(error);
    throw new Error("Error al eliminar el artículo");
  }
};

</script>

<template>
  <div>
    <button @click="nuevaPublicacion"
      class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 border border-green-500 rounded ml-auto">
      Nueva Publicación
    </button>
    <div v-if="isError" class="error-message">
      Ha ocurrido un error al cargar los artículos, error: {{ errorMessage }}...
    </div>
    <div v-else-if="isLoading" class="loading-message">
      Cargando artículos...
    </div>
    <div v-else>
      <table class="min-w-full border-collapse block md:table article-table">
        <thead class="block md:table-header-group">
          <tr
            class="border border-grey-500 md:border-none block md:table-row absolute -top-full md:top-auto -left-full md:left-auto md:relative">
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              ID
            </th>
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              Título
            </th>
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              Autor
            </th>
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              Contenido
            </th>
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              Creado
            </th>
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              Actualizado
            </th>
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              Publicar
            </th>
            <th class="bg-gray-600 p-2 text-white font-bold md:border md:border-grey-500 text-left block md:table-cell">
              Actions
            </th>
          </tr>
        </thead>
        <tbody class="block md:table-row-group">
          <tr v-for="(article, index) in articles" :key="index"
            class="bg-gray-300 border border-grey-500 md:border-none block md:table-row">
            <td class="p-2 md:border md:border-grey-500 text-left block md:table-cell">
              <span class="inline-block w-1/3 md:hidden font-bold">ID</span>
              {{ article.id }}
            </td>
            <td class="p-2 md:border md:border-grey-500 text-left block md:table-cell">
              <span class="inline-block w-1/3 md:hidden font-bold">Titulo:</span>
              {{ article.title }}
            </td>
            <td class="p-2 md:border md:border-grey-500 text-left block md:table-cell">
              <span class="inline-block w-1/3 md:hidden font-bold">Autor:</span>
              {{ article.author }}
            </td>
            <td class="p-2 md:border md:border-grey-500 text-left block md:table-cell">
              <span class="inline-block w-1/3 md:hidden font-bold">Contenido:</span>
              {{ article.content }}
            </td>
            <td class="p-2 md:border md:border-grey-500 text-left block md:table-cell">
              <span class="inline-block w-1/3 md:hidden font-bold">Creación:</span>
              {{ article.createdAt }}
            </td>
            <td class="p-2 md:border md:border-grey-500 text-left block md:table-cell">
              <span class="inline-block w-1/3 md:hidden font-bold">Actualizado:</span>
              {{ article.updatedAt }}
            </td>
            <td class="p-2 md:border md:border-grey-500 text-left block md:table-cell">
              <span class="inline-block w-1/3 md:hidden font-bold">Publicado:</span>
              {{ article.published ? "Si" : "No" }}
            </td>

            <td class="p-2 md:border md:border-grey-500 text-center block md:table-cell" style="width: 200px">
              <span class="inline-block w-1/3 md:hidden font-bold">Actions</span>
              <div class="flex justify-center space-x-2">
                <button @click="editArticle(article)"
                  class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 border border-blue-500 rounded">
                  Edit
                </button>
                <button @click="deleteArticle(article.id)"
                  class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 border border-red-500 rounded">
                  Delete
                </button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
      <div v-if="showSuccessMessage" class="success-message">
        ¡Artículos cargados con éxito!
      </div>
    </div>
  </div>
</template>

<style scoped>
/* Estilos para mensajes de error, carga y éxito */
.error-message {
  color: #ff0000;
  font-weight: bold;
  margin-bottom: 20px;
}

loading-message {
  font-weight: bold;
  margin-bottom: 20px;
}

.success-message {
  color: #0714c9;
  font-weight: bold;
  margin-top: 20px;
}
</style>
