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
export function savePassageAPI(data) {
    return axios({
        url:`${api.passagesPre}/save`,
        method:'POST',
        data
    })
}
export function updatePassageAPI(data) {
    return axios({
        url:`${api.passagesPre}/update`,
        method:'POST',
        data
    })
}
export function deletePassageAPI(id) {
    return axios({
        url:`${api.passagesPre}/${id}/delete`,
        method:'GET'
    })
}

export function getUserBlogsAPI(id) {
    return axios({
        url:`${api.passagesPre}/${id}/list`,
        method:'GET'
    })
}
export function isInCollectionAPI(data) {
    return axios({
        url:`${api.passagesPre}/isInCollection`,
        method:'GET',
        params:{userId:data.userId,passageId:data.passageId}
    })
}

export function getMostPopularPassagesAPI(id) {
    return axios({
        url:`${api.passagesPre}/${id}/getMostPopularPassages`,
        method:'GET'
    })
}

export function listCreateTimeAPI(id){
    return axios({
        url:`${api.passagesPre}/${id}/listCreateTime`,
        method:'GET'
    })
}

export function getRandomPassagesAPI(){
    return axios({
        url:`${api.passagesPre}/getRandomPassages`,
        method:'GET'
    })
}