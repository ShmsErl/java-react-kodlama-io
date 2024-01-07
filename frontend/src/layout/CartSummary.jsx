import React from "react";
import { useSelector } from "react-redux";

import { NavLink } from "react-router-dom";
import { Dropdown, Label } from "semantic-ui-react";
export default function CartSummary() {

    const { cardItems } = useSelector((state) => state.cart);
    console.log(cardItems.product)

    return (
        <div>   
            <Dropdown item text='Sepetiniz'>
                <Dropdown.Menu>
                    {
                        cardItems.map((cartItem) => (
                            <Dropdown.Item > {cartItem.product.name}
                            
                            <Label primary>
                                {cartItem.quantity}
                            </Label>
                            </Dropdown.Item> // Her öğeye unique bir key eklenmeli
                            
                        ))
                    }
                    <Dropdown.Divider/>
                    <Dropdown.Item as={NavLink} to="/cart">Shopping Cart</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>
        </div>
    )

}