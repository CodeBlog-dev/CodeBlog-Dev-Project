<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
    setup() {
        const articles = ref([]); // Almacena los artículos obtenidos del backend
        const newArticle = ref({
            id: null,
            title: "",
            content: "",
        });

        const fetchArticles = () => {
            axios.get('http://localhost:9000/api/v1/articles')
                .then(response => {
                    articles.value = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        };

        const createArticle = () => {
            axios.post('http://localhost:9000/api/v1/articles', newArticle.value)
                .then(response => {
                    // Lógica para manejar la respuesta del backend
                    newArticle.value.id = response.data.id;
                    articles.value.push(newArticle.value);
                    newArticle.value = { id: null, title: "", imageURL: "", author: "", date: "", content: "" };
                })
                .catch(error => {
                    console.error(error);
                });
        };

        const editArticle = (article) => {
            newArticle.value = { id: article.id, title: article.title, imageURL: article.imageURL, author: article.author, date: article.date, content: article.content };
        };

        const deleteArticle = (articleId) => {
            axios.delete(`http://localhost:9000/api/v1/articles/${articleId}`)
                .then(() => {
                    articles.value = articles.value.filter(article => article.id !== articleId);
                })
                .catch(error => {
                    console.error(error);
                });
        };

        const submitArticle = (event) => {
            event.preventDefault();
            if (newArticle.value.id) {
                // Si el artículo ya tiene un ID, entonces estamos editando
                axios.put(`http://localhost:9000/api/v1/articles/${newArticle.value.id}`, newArticle.value)
                    .then(() => {
                        // Lógica para manejar la respuesta del backend
                        const index = articles.value.findIndex(article => article.id === newArticle.value.id);
                        if (index !== -1) {
                            articles.value[index] = newArticle.value;
                        }
                        newArticle.value = { id: null, title: "", imageURL: "", author: "", date: "", content: "" };
                    })
                    .catch(error => {
                        console.error(error);
                    });
            } else {
                // Si el artículo no tiene un ID, entonces estamos creando uno nuevo
                createArticle();
            }
        };

        onMounted(fetchArticles);

        return {
            newArticle,
            editArticle,
            deleteArticle,
            submitArticle
        };
    },
};
</script>
<template>
    <div class="container mx-auto p-4">
        <h1 class="text-2xl font-bold mb-4">Artículos</h1>

        <!-- Formulario para crear/editar artículos -->
        <form @submit="submitArticle" class="mb-4">
            <div class="mb-4">
                <label for="title" class="block font-bold">Título</label>
                <input v-model="newArticle.title" type="text" id="title" class="w-full border border-gray-300 rounded p-2">
            </div>
            <div class="mb-4">
                <label for="title" class="block font-bold">ImagenURL</label>
                <input v-model="newArticle.imageURL" type="text" id="title"
                    class="w-full border border-gray-300 rounded p-2">
            </div>
            <div class="mb-4">
                <label for="title" class="block font-bold">Autor</label>
                <input v-model="newArticle.author" type="text" id="title" class="w-full border border-gray-300 rounded p-2">
            </div>
            <!-- <div class="mb-4">
                <label for="title" class="block font-bold">Fecha</label>
                <input v-model="newArticle.date" type="text" id="title" class="w-full border border-gray-300 rounded p-2">
            </div> 
            TODO: NO FUNCIONA CORRECTAMENTE-->

            <div class="mb-4">
                <label for="content" class="block font-bold">Contenido</label>
                <textarea v-model="newArticle.content" id="content" rows="4"
                    class="w-full border border-gray-300 rounded p-2"></textarea>
            </div>
            <button type="submit"
                class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Guardar</button>
        </form>

        <div>
            <h1>Tabla de Ejemplo</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Edad</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="article in articles" :key="article.id">
                        <td>{{ article.id }}</td>
                        <td>{{ article.title }}</td>
                        <td>{{ article.id }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- Lista de artículos -->

    </div>
</template>

 
  