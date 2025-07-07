package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.dto.request.CreateCommentRequest;
import org.echoplay.echoplay.dto.response.CommentResponse;
import org.echoplay.echoplay.entity.Comment;
import org.echoplay.echoplay.entity.MediaFile;
import org.echoplay.echoplay.entity.User;
import org.echoplay.echoplay.mapper.CommentMapper;
import org.echoplay.echoplay.repository.CommentRepository;
import org.echoplay.echoplay.service.CommentService;
import org.echoplay.echoplay.service.MediaFileService;
import org.echoplay.echoplay.service.UserService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final MediaFileService mediaFileService;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, MediaFileService mediaFileService, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.mediaFileService = mediaFileService;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentResponse> getAllCommentByMediaId(Long mediaId) {
        List<Comment> comments=commentRepository.findAllByMediaFileId(mediaId);
        return List.of();
    }

    @Override
    public void createComment(CreateCommentRequest createCommentRequest) {
        User user=userService.getUserById(createCommentRequest.getUserId());
        MediaFile mediaFile=new MediaFile();//S3'Den media çekilecek ve mapper'a verilecek

        Comment comment=commentMapper.toComment(createCommentRequest,mediaFile,user);

        commentRepository.save(comment);


    }

    @Override
    public void deleteComment(Long commentId) {

    }
}
