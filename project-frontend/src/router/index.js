import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import DashboardView from '../views/dashboard/DashboardView.vue'
import ArticleEditView from '../views/dashboard/ArticleEditView.vue'
import ArticleNewView from '../views/dashboard/ArticleNewView.vue'
import ArticleDetailView from '../views/ArticleDetailView.vue'
import NotFound from '../components/global/NotFound.vue'; // Asegúrate de que este componente esté importado correctamente


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // Home
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    // Articles detail
    {
      path: '/articles/:id',
      name: 'article-detail',
      component: ArticleDetailView
    },
     // Edit Articles
     {
      path: '/dashboard/articles/new',
      name: 'new-article',
      component: ArticleNewView
    },
    // Edit Articles
    {
      path: '/dashboard/articles/:id',
      name: 'article-edit',
      component: ArticleEditView
    },
    // dashboard
    {
      path: '/dashboard',
      name: 'dashboard',
      component: DashboardView
    },
    // Not found
    {
      path: '/:pathMatch(.*)*',
      name: 'not-found',
      component: NotFound,
    }
  ]
})

export default router
