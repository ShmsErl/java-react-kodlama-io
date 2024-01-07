
import { Container } from 'semantic-ui-react';
import './App.css';

import Nav from './layout/Nav';
import Dashboard from './layout/Dashboard';
import 'semantic-ui-css/semantic.min.css';
import { Provider } from 'react-redux';


function App() {
  return (
    <div className="App">

      <Nav />
      <Container className='main'>
        <Dashboard />
      </Container>


    </div>
  );
}

export default App;
