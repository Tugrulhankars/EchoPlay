package org.echoplay.echoplay.mapper;

import org.echoplay.echoplay.dto.request.CreateCommentRequest;
import org.echoplay.echoplay.entity.Comment;
import org.echoplay.echoplay.entity.MediaFile;
import org.echoplay.echoplay.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentMapper {

    public Comment toComment(CreateCommentRequest request, MediaFile mediaFile, User user){
        Comment comment=new Comment();
        comment.setContent(request.getComment());
        comment.setMediaFile(mediaFile);
        comment.setAuthor(user);
        comment.setCommentedAt(LocalDateTime.now());
        return comment;
    }
}
