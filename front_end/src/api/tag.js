import { axios } from '../utils/request.js'
const api = {
    tagsPre: '/api/tags'
}
export function getTagsByUserAPI(id){
    return axios({
        url: `${api.tagsPre}/${id}/getTagsByUser`,
        method: 'GET'
    })
}

export function saveTagAPI(data){
    return axios({
        url: `${api.tagsPre}/saveTag`,
        method: 'POST',
        data
    })
}
