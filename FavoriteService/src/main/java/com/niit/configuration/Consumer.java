package com.niit.configuration;


import com.niit.domain.Cart;
import com.niit.domain.Favorite;
import com.niit.domain.Order;
import com.niit.service.FavoriteServiceImpl;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		Cart cart = new Cart();
		Order order = new Order();
		order.setEmail(messageDTO.getEmail());
		cart.setEmail(messageDTO.getEmail());
		favorite.setEmail(messageDTO.getEmail());
		System.out.println(favorite);
		favoriteServiceimpl.saveFavorite(favorite);
		favoriteServiceimpl.saveCart(cart);
		favoriteServiceimpl.saveOrder(order);

	}
}
