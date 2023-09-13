<script setup>
import { RouterLink, RouterView } from 'vue-router'
import NavbarComponent from './components/global/NavbarComponent.vue';
import FooterComponent from './components/global/FooterComponent.vue';
</script>

<template>
  <header>
    <NavbarComponent />
  </header>
  <RouterView />
  <footer>
    <FooterComponent />
  </footer>
</template>

<style scoped></style>
