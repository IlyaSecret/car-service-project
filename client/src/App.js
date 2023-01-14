
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.scss';
import MainPage from "./pages/main-page/main-page";
import Header from './components/header/header';
import PersonalAccount from './pages/personal-account/personal-account';
import { Provider } from 'react-redux';
import { store } from './store';


function App() {
  return (
    <Provider store={store}>
      <BrowserRouter >
        <Routes>
          <Route path='/' element={<MainPage />} />
          <Route path='/personal-account' element={<PersonalAccount />} />
        </Routes>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
