<script setup>
import { RouterLink, RouterView } from 'vue-router'
import NavbarComponent from './components/global/NavbarComponent.vue';
</script>

<template>
  <header>
    <NavbarComponent/>
  </header>
  <RouterView />
</template>

<style scoped>
</style>
