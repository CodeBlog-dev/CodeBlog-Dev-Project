import api from "../lib/axios";

export default {
    arcliclesList() {
        return api.get('/articles')
    },
    agregarCliente(data) {
        return api.post('/articles', data)
    },
    obtenerCliente(id) {
        return api.get('/articles/' + id)
    },
    actualizarCliente(id, data) {
        return api.patch('/articles/' + id, data)
    },
    eliminarCliente(id) {
        return api.delete('/articles/' + id)
    }
}
