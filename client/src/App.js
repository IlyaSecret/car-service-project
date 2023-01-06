
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.scss';
import MainPage from "./pages/main-page/main-page";
import Header from './components/header/header';
import PersonalAccount from './pages/personal-account/personal-account';


function App() {
  return (
    <BrowserRouter >
      <Routes>
        <Route path='/' element={<MainPage />} />
        <Route path='/personal-account' element={<PersonalAccount />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
