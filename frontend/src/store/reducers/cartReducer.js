import { ADD_TO_CART, REMOVE_FROM_CART } from "../actions/cardActions";
import { cardItems } from "../initialValues/cartItems";

const initialState = { cardItems: cardItems }

export default function cartReducer(state = initialState, { type, payload }) {

    switch (type) {
        case ADD_TO_CART:

            let existingProduct = state.cardItems.find(
                (item) => item.product.id === payload.id
            );
            if (existingProduct) {
                let updatedItems = state.cardItems.map((item) =>
                    item.product.id === payload.id
                        ? { ...item, quantity: item.quantity + 1 }
                        : item
                );
                return { ...state, cardItems: updatedItems };
            } else {
                return {
                    ...state,
                    cardItems: [...state.cardItems, { product: payload, quantity: 1 }],
                };
            }
        case REMOVE_FROM_CART:
            let existingItem = state.cardItems.find(item => item.product.id === payload.id);

            if (existingItem) {
                let updatedItems = state.cardItems.filter(item => item.product.id !== payload.id);
                return { ...state, cardItems: updatedItems };
            } else {
                // Return the existing state if no matching item is found
                return state;
            }

        default:
            return state

    }

}