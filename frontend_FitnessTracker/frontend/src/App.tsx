import React from 'react';
import Header from './components/header';


import './App.css';
//import ImageComponent from "./components/ImageLogo";
import Footer from "./components/footer";
//import InsertButton from "./components/insertButton";
import MuiTextField from "./components/textField";

function App(): JSX.Element {
  const handleInsertPerson = (person: any) => {
    // Add your logic to insert the person here
    console.log("Inserting person:", person);
  };

  const handleSelectPerson = (personId: number | null) => {
    // Logica pentru selectarea persoanei
    console.log("Selected person ID:", personId);
  };

  return (<div className="App">
    <Header />
    <div  style={{ display: 'flex', marginLeft: '2rem'}}>
    <MuiTextField onInsertPerson={handleInsertPerson}
      onSelectPerson={handleSelectPerson}/>
      {/* <InsertButton/> */}
      </div>
      <div>
      <Footer />
      </div>
  </div>
  );
}

export default App;
