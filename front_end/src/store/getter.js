const getters={
    //passages
    searchResult:state=>state.passages.searchResult,
    passageDetail:state=>state.passages.passageDetail,
    userBlogs:state=>state.passages.userBlogs,
    //user
    //getter能干啥来着。。。
    token: state => state.user.token,
    userId:state=>state.user.user_id,
    collection:state=>state.user.collection,
    inCollection: state=>state.user.inCollection,
    //comment
    commentList:state=>state.comment.commentList

}
export default getters