package com.gardenshop.personal.converter;

import com.gardenshop.personal.dto.favorite.FavoriteRequestDto;
import com.gardenshop.personal.dto.favorite.FavoriteResponseDto;
import com.gardenshop.personal.model.favorite.Favorite;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class FavoriteConverter {

    public Favorite toEntity(FavoriteRequestDto dto, User user, Product product) {
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setProduct(product);
        return favorite;
    }

    public FavoriteResponseDto toDto(Favorite favorite) {
        return new FavoriteResponseDto(
                favorite.getId(),
                favorite.getProduct().getName(),
                favorite.getUser().getEmail()
        );
    }
}
