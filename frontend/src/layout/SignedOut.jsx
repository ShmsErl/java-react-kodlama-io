import React from 'react'
import { Button, Menu } from 'semantic-ui-react'

export default function SignedOut(props) {
    return (
        <div>
            <Menu.Item>
                <Button primary >Sign İn</Button>
                <Button onClick={props.SignedIn} primary style = {{marginLeft:"1em"}}>Login</Button>

            </Menu.Item>

        </div>
    )
}
