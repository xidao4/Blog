import { axios } from '../utils/request.js'
const api = {
    tagsPre: '/api/tags'
}
export function getUserInfoAPI(id){
    return axios({
        url: `${api.tagsPre}/${id}/getUserInfo`,
        method: 'GET'
    })
}