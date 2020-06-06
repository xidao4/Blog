import { axios } from '../utils/request.js'
const api = {
    passagesPre: '/api/passages'
}
export function searchAPI(key){
    return axios({
        url:`${api.passagesPre}/${key}/searchPassages`,
        method: 'GET',
    })
}

export function getPassageAPI(id) {
    return axios({
        url:`${api.passagesPre}/${id}/passage`,
        method:'GET'
    })
}

export function addCollectionAPI(data) {
    return axios({
        url:`${api.passagesPre}/createCollection`,
        method:'POST',
        data
    })
}
export function getCollectionAPI(userId) {
    return axios({
        url:`${api.passagesPre}/${userId}/searchCollection`,
        method: 'GET',
    })
}
export function deleteCollectionAPI(data) {
    return axios({
        url:`${api.passagesPre}/deleteCollection`,
        method:'POST',
        data
    })
}