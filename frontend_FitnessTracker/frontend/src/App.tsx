import React from 'react';
import Header from './components/header';


import './App.css';
import { MuiTextField} from "./components/textField";
//import ImageComponent from "./components/ImageLogo";
import Footer from "./components/footer";


function App(): JSX.Element {
  return (<div className="App">
    <Header />
    <div  style={{ display: 'flex', marginLeft: '2rem'}}>
    <MuiTextField />
      </div>
      <div>
      <Footer />
      </div>
  </div>
  );
}

export default App;
