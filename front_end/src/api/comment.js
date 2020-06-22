import { axios } from '../utils/request.js'
const api = {
    commentPre: '/api/comment'
}
export function getCommentByPassageIdAPI(passageId) {
    return axios({
        url:`${api.commentPre}/${passageId}/getCommentByPassageId`,
        method: 'GET',
    })
}
export function addCommentAPI(data) {
    return axios({
        url:`${api.commentPre}/create`,
        method: 'POST',
        data
    })
}

export function deleteCommentAPI(id) {
    return axios({
        url:`${api.commentPre}/${id}/delete`,
        method: 'POST',
    })
}