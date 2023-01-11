package com.niit.configuration;


import com.niit.domain.Favorite;
import com.niit.service.FavoriteServiceImpl;
import com.niit.service.IFavoriteService;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Consumer {
	@Autowired
	private final FavoriteServiceImpl favoriteServiceimpl;
	@Autowired
	public Consumer(FavoriteServiceImpl favoriteServiceimpl) {
		this.favoriteServiceimpl = favoriteServiceimpl;
	}


	@RabbitListener(queuesToDeclare = @Queue("messageQueue"))
	public void getData(MessageDTO messageDTO) {
		Favorite favorite = new Favorite();
		favorite.setEmail(messageDTO.getEmail());
		System.out.println(favorite);
		favoriteServiceimpl.saveFavorite(favorite);
	}
}
