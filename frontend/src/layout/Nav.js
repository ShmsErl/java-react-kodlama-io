import React, { useState } from 'react'
import CartSummary from './CartSummary'
import {  Container, Menu, Segment } from 'semantic-ui-react'
import SignedOut from './SignedOut'
import SignedIn from './SignedIn'
import { NavLink, useNavigate } from 'react-router-dom'
import { useSelector } from 'react-redux'

export default function Nav() {

    const [isAuthentication, setIsAuthentication] = useState(true)
    const { cardItems } = useSelector((state) => state.cart);
    const history = useNavigate()
    function handleSignOut(params){

         setIsAuthentication(false)
         history('/')
    }
    function handleSignIn(params){

        setIsAuthentication(true)
   }
    return (
        <div>
            <Segment inverted>
            <Menu size='massive' inverted secondary>
            <Container>
                <Menu.Item
                   as={NavLink} to = '/' name='home'

                />
                <Menu.Item
                    name='messages'

                />

                <Menu.Menu position='right'>
            {cardItems.length > 0 && <CartSummary/>}

                    {
                        isAuthentication ? <SignedIn SignedOut = {handleSignOut} bisey="1" />  : <SignedOut SignedIn = {handleSignIn} bisey="0"/>
                    }

                  
                    
                </Menu.Menu>
                </Container>
            </Menu>
        </Segment>
         </div>
    )
}
