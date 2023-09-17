import api from "../lib/axios";

export default {
    articlesList() {
        return api.get('/articles')
    },
    addArticle(data) {
        return api.post('/articles', data)
    },
    getArticle(id) {
        return api.get('/articles/' + id)
    },
    updateArticle(id, data) {
        return api.patch('/articles/' + id, data)
    },
    deleteArticle(id) {
        return api.delete('/articles/' + id)
    }
}
