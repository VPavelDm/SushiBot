package com.vpaveldm.bot.processor;


import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnAmountMessage;
import com.vpaveldm.database.model.Basket;
import com.vpaveldm.database.model.BasketItem;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.repository.BasketRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OnMoreProcessor implements InlineKeyboardButtonProcessor {
    private final UserRepository userRepository;
    private final ItemRepository repository;
    private final BasketRepository basketRepository;

    @Override
    public boolean supports(String message) {
        return message.endsWith(Messages.MORE);
    }

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
        Optional<User> user = userRepository.findUserByTelegramId(query.getFrom().getId().longValue());
        if (!user.isPresent()) {
            return;
        }
        Basket basket = user.get().getBasket();

        int fDots = query.getData().indexOf(":");
        int sDots = query.getData().indexOf(":", fDots + 1);
        Long id = Long.valueOf(query.getData().substring(fDots + 1, sDots));

        Optional<Item> item = repository.findById(id);
        if (!item.isPresent()) {
            return;
        }
        Optional<BasketItem> basketItem = basket.getBasketItems()
                .stream()
                .filter(bi -> bi.getItem().equals(item.get()))
                .findFirst();
        long count;
        if (basketItem.isPresent()) {
            count = basketItem.get().getCount() + 1;
            basketItem.get().setCount(count);
        } else {
            count = 1L;
            BasketItem newBasketItem = BasketItem.builder()
                    .basket(basket)
                    .item(item.get())
                    .count(count)
                    .build();
            basket.getBasketItems().add(newBasketItem);
        }
        basketRepository.save(basket);

        getExecute(sender, new OnAmountMessage(item.get(), count).get(query.getMessage()));
    }
}
