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

export function getTagsByPassageAPI(id) {
    return axios({
        url:`${api.tagsPre}/${id}/list`,
        method:'GET'
    })
}