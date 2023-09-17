<script setup>
import { ref, onMounted } from "vue";
import api from "../../lib/axios.js";

const article = ref({
  title: "",
  imageURL: "",
  author: "",
  content: "",
});
const isLoading = ref(true);
const isError = ref(false);
const errorMessage = ref("");
const showSuccessMessage = ref(false);

// Get article ID from path
const articleId = window.location.pathname.split("/").pop();

// Called when the component is mounted (ready to be used)
onMounted(async () => {
  try {
    const response = await getArticle(articleId);
    article.value = response.data;
    isLoading.value = false;
  } catch (error) {
    errorMessage.value = error.message;
    isError.value = true;
  }
});

// Get article from backend
const getArticle = async (articleId) => {
  try {
    const response = await api.get(`/articles/${articleId}`);
    return response.data;
  } catch (error) {
    throw new Error("Error al obtener el artículo. Error: " + error);
  }
};

// Submit article
const submitArticle = async (event) => {
  event.preventDefault();
  try {
    await api.put(`/articles`, article.value);
    showSuccessMessage.value = true;
  } catch (error) {
    errorMessage.value = "Error al actualizar el artículo";
    isError.value = true;
  }
};
</script>

<template>
  <div>
    <div v-if="showSuccessMessage" class="success-message">
        <div class="block w-full">
          <div
            class="font-regular relative mb-4 block w-full rounded-lg bg-green-500 p-4 text-base leading-5 text-white opacity-100"
          >
            A success alert for showing message.
          </div>
      </div>
    </div>
    <div v-if="isError" class="error-message">
      Ha ocurrido un error: {{ errorMessage }}.
      <div
        class="font-regular relative mb-4 block w-full rounded-lg bg-red-500 p-4 text-base leading-5 text-white opacity-100"
      >
        An error alert for showing message.
      </div>
    </div>
    <div v-else-if="isLoading" class="loading-message">
      Cargando artículos...
    </div>
    <div v-else>
      <div class="container mx-auto p-4">
        <h1 class="text-2xl font-bold mb-4">Artículo</h1>
        <form @submit="submitArticle" class="mb-4">
          <div class="mb-4">
            <label for="title" class="block font-bold">Título</label>
            <input
              v-model="article.title"
              type="text"
              id="title"
              class="w-full border border-gray-300 rounded p-2"
            />
          </div>
          <div class="mb-4">
            <label for="imageURL" class="block font-bold">ImagenURL</label>
            <input
              v-model="article.imageURL"
              type="text"
              id="imageURL"
              class="w-full border border-gray-300 rounded p-2"
            />
          </div>
          <div class="mb-4">
            <label for="author" class="block font-bold">Autor</label>
            <input
              v-model="article.author"
              type="text"
              id="author"
              class="w-full border border-gray-300 rounded p-2"
            />
          </div>

          <div class="mb-4">
            <label for="content" class="block font-bold">Contenido</label>
            <textarea
              v-model="article.content"
              id="content"
              rows="4"
              class="w-full border border-gray-300 rounded p-2"
            ></textarea>
          </div>
          <button
            type="submit"
            @click="submitArticle"
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          >
            Guardar
          </button>
        </form>
      </div>
    </div>
  </div>
</template>
