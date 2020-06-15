const getters={
    //passages
    searchResult:state=>state.passages.searchResult,
    passageDetail:state=>state.passages.passageDetail,
    userBlogs:state=>state.passages.userBlogs,
    inCollection: state=>state.passages.inCollection,
    //user
    token: state => state.user.token,
    userId:state=>state.user.user_id,
    collection:state=>state.user.collection,
    userTags:state=>state.user.userTags,
    //comment
    commentList:state=>state.comment.commentList

}
export default getters