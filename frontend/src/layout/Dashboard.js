import React from 'react'
import { Button, Grid, GridColumn, Divider } from 'semantic-ui-react';

import Categories from './Categories';
import ProductsList from '../pages/ProductsList';

import { Route, Routes } from 'react-router-dom';
import ProductDetails from './ProductDetails';
import CartDetail from './CartDetail';
import { ToastContainer } from 'react-toastify';

export default function Dashboard() {
  return (
    <div>
      <ToastContainer position="bottom-right"/>
      <Divider horizontal style={{ margin: '10px 0' }}></Divider>
      <Grid>
        <Grid.Row>
          <Grid.Column width={4}>
            <Categories />

          </Grid.Column>
          <Grid.Column width={12}>
            <Routes>
              <Route exact path='/' Component={ProductsList} />
              <Route exact path='/products' Component={ProductsList} />
              <Route exact path='/products/:id' Component={ProductDetails} />
              <Route  path='/cart' Component={CartDetail} />
            </Routes>
          </Grid.Column>
        </Grid.Row>

      </Grid>


    </div>
  )
}
