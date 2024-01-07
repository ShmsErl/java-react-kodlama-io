import React,{useState,useEffect}  from 'react'
import { Card, Button,Image } from 'semantic-ui-react'
import { useParams } from 'react-router-dom'
import ProductService from '../services/productService';

export default function ProductDetails() {
    let { id } = useParams();
    const [product, setProduct] = useState({});

    useEffect(() => {
        const fetchData = async () => {
          try {
            let productService = new ProductService();
            const result = await productService.getProductsById(id);
            setProduct(result.data);
          } catch (error) {
            console.error('Ürün alma hatası:', error);
          }
        };
    
        fetchData();
      }, [id]);
    
    
    return (
        <div>
            <Card.Group>
    <Card fluid>
    <Image fluid src='https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcSW5xNiyzNbj74lFoZi6apGQ32gUYxP8fELMN5RbLWoiRQQRf9CZxo8jcC9l6xthf81Jc1suCLoL2pHI74UULGLGX66QG0QyWubYj563GfTnXeAMZNtg-0O&usqp=CAE' wrapped ui={false} />

      <Card.Content>
        <Card.Header>{product.name}</Card.Header>
        <Card.Meta>{product.unitPrice}$</Card.Meta>
        <Card.Description>
          Steve wants to add you to the group <strong>best friends</strong>
        </Card.Description>
      </Card.Content>
      <Card.Content extra>
        <div className='ui two buttons'>
          <Button basic color='green'>
            Approve
          </Button>
          <Button basic color='red'>
            Decline
          </Button>
        </div>
      </Card.Content>
    </Card>
    
  </Card.Group>

            

            
        </div>
    )
}
