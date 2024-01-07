import React from 'react'
import { Dropdown, Menu,Image } from 'semantic-ui-react'

export default function SignedIn(props) {
  return (
    <div>
        <Menu.Item>
            <Image avatar spaced = "right" src ="https://img.freepik.com/premium-psd/3d-cartoon-man-smiling-portrait-isolated-transparent-background-png-psd_888962-1569.jpg" ></Image>
            <Dropdown pointing= "top left" text='Şeyhmus'>
                <Dropdown.Menu>
                    <Dropdown.Item text="Bilgilerim" icon="info"    />
                    <Dropdown.Item onClick={props.SignedOut} text="Çıkış Yap" icon="sign-out"    />
                </Dropdown.Menu>
            </Dropdown>
        </Menu.Item>
    </div>
  )
}
