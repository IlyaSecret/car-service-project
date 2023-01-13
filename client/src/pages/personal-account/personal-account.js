import { useState } from "react";
import './personal-account.scss';
import { Link, useNavigate } from "react-router-dom";
import PersonalAccountServices from "../../components/personal-account-services/personal-account-services";
import PersonalAccountHistory from "../../components/personal-account-history/personal-account-history";
import { useDispatch, useSelector } from "react-redux";
import { resetState } from "../../store/reducer/reducer";
import { AuthorizationStatus } from "../../consts";
import PersonalInfo from "../../components/personal-info/personal-info";
import { FaTelegramPlane } from "react-icons/fa";

export default function PersonalAccount() {
  const [currentTab, setCurrentTab] = useState('services');
  const dispatch = useDispatch()
  const authStatus = useSelector(state => state.authStatus);
  const navigate = useNavigate();
  if (authStatus !== AuthorizationStatus.Auth) {
    return (
    <>
      <h2>Вы не авторизованы</h2>
      <Link to="/">На главную</Link>
    </>
    )
  }
  return (
    <div className="personal-account">
        <div className="personal-account__nav">
        <Link to='/' id="personal-account__nav__title"><img src="./img/logo.svg" width="178px" height="64px" ></img></Link>
            <ul className="personal-account__nav__ul">
              <li className={`personal-account__nav__ul__item ${currentTab === 'services' && 'active'}`} onClick={() => setCurrentTab('services')}>Услуги</li>
              <li className={`personal-account__nav__ul__item ${currentTab === 'history' && 'active'}`} onClick={() => setCurrentTab('history')}>История обсуживания</li>
              <li className={`personal-account__nav__ul__item ${currentTab === 'info' && 'active'}`} onClick={() => setCurrentTab('info')}>Инофрмация об аккаунте</li>
            </ul>

            <a href="https://t.me/Aut0Help_bot" className="telegram" target="_blank"><img src="./img/contacts-img/telegram.png" style={{width: "40px", height: "40px"}}></img></a>
            <button className="personal-account__nav--logout" onClick={() => {
              dispatch(resetState())
              navigate('/');
            }}>Выйти</button>
        </div>

        <div className="personal-account__content">
            {
              currentTab === 'services' && <PersonalAccountServices />
            }
            {
              currentTab === 'history' && <PersonalAccountHistory />
            }
            {
              currentTab === 'info' && <PersonalInfo />
            }
        </div>
    </div>
  );
}
