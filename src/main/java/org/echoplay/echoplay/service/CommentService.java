package org.echoplay.echoplay.service;

import org.echoplay.echoplay.dto.request.CreateCommentRequest;
import org.echoplay.echoplay.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getAllCommentByMediaId(Long mediaId);
    void createComment(CreateCommentRequest createCommentRequest);
    void deleteComment(Long commentId);

}
