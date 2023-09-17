<script setup>
import { onMounted, ref, computed } from 'vue'
import ArticleService from '../../services/ArticleService'

const articles = ref([])

onMounted(() => {
  ArticleService.articlesList()
    .then(({ data }) => articles.value = data.data)
    .catch(error => console.log('Hubo un error'))
})

defineProps({
  titulo: {
    type: String
  }
})

const isEmpyArticles = computed(() => {
  console.log(articles.value.length)
  return articles.value.length > 0
})

const redirectToArticles = (articleId) => {
  console.log(articleId)
  window.location.href = `/articles/${articleId}`
}
</script>

<template>
  <div class="flow-root mx-auto mt-10 p-5 bg-white shadow" v-if="articles.length > 0">
    <ul class="grid grid-cols-1 gap-6 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
      <li v-for="article in     articles    " :key="article.id">
        <div class="bg-white shadow-md border border-gray-200 rounded-lg max-w-sm dark:bg-gray-800 dark:border-gray-700"
          style="background-color: #d700afce;">
          <a :href="article.url">
            <img class="rounded-t-lg" :src="article.imageURL" alt="">
          </a>

          <div class="p-5">
            <a :href="article.url">
              <h5 class="text-gray-900 font-bold text-2xl tracking-tight mb-2 dark:text-white">{{ article.title }}</h5>
            </a>
            <p class="font-normal text-gray-700 mb-3 dark:text-gray-400">{{ article.description }}</p>
            <div class="flex items-center justify-between">
              <button @click="redirectToArticles(article.id)" type="button"
                class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-3 py-2 inline-flex items-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                style="background-color: #04126a;">
                Leer más
                <svg class="-mr-1 ml-2 h-4 w-4" fill="currentColor" viewBox="0 0 20 20"
                  xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd"
                    d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z"
                    clip-rule="evenodd"></path>
                </svg>
              </button>
            </div>
          </div>
        </div>
      </li>
    </ul>
  </div>
  <p v-else class="text-center mt-10">No Hay Articulos</p>
</template>

<style scoped></style>
