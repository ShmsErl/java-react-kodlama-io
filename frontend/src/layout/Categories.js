import React, { useState, useEffect } from "react";
import { Container, Divider, Menu } from "semantic-ui-react";

export default function Categories() {

  const [categories, setCategories] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/categories/getall").then(response => response.json()).then(data => setCategories(data)).catch(error => console.error('Ürünleri alma hatası:', error))





  })


  return (

    <div>




      <Menu pointing vertical>
        {
          categories.map(category => (
            <Menu.Item
              name={category.categoryName}

            />

          ))

        }





      </Menu>

    </div>
  )
}