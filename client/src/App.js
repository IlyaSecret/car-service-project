
import { useRef } from 'react';
import './App.scss';
import AboutUs from './components/about-us/about-us';
import Header from './components/header/header';
import Services from './components/services/services';
import SignInForm from './components/sign-in-form/sign-in-form';

function App() {
  return (
    <div className="App">
      <Header/>
      <SignInForm />
      <AboutUs />
      <Services />
    </div>
  );
}

export default App;
