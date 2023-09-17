<script setup>
import { onMounted, ref, computed } from 'vue'
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
</script>

<!-- Article detail template-->
<template>
  <div class="bg-white p-6 rounded-lg shadow-lg">
    <h1 class="text-3xl font-bold mb-4">{{ article.title }}</h1>
    <div class="text-gray-500 mb-4">
      <p class="text-sm">Por: {{ article.author }}</p>
      <p class="text-sm">Publicado el: {{ article.date }}</p>
    </div>
    <p class="text-base leading-7 mb-4">{{ article.content }}</p>
    <router-link to="/articles" class="text-blue-500 hover:underline">Volver a la Lista de Artículos</router-link>
  </div>
</template>
  

  