
import { useRef } from 'react';
import './App.scss';
import AboutUs from './components/about-us/about-us';
import BestSides from './components/best-sides/best-sides';
import Comments from './components/comments/comments';
import Contacts from './components/contacts/contacts';
import Footer from './components/footer/footer';
import Gallery from './components/gallery/gallery';
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
      <BestSides />
      <Contacts />
      <Gallery />
      <Comments />
      <Footer />
    </div>
  );
}

export default App;
