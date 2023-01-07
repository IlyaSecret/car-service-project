import { useState } from "react";
import './personal-account.scss';
import { Link } from "react-router-dom";
import PersonalAccountServices from "../../components/personal-account-services/personal-account-services";
import PersonalAccountHistory from "../../components/personal-account-history/personal-account-history";

export default function PersonalAccount() {
  const [currentTab, setCurrentTab] = useState('services');
  console.log(currentTab);
  return (
    <div className="personal-account">
        <div className="personal-account__nav">
        <Link to='/' id="personal-account__nav__title"><img src="./img/logo.svg" width="178px" height="64px" ></img></Link>
            <ul className="personal-account__nav__ul">
              <li className={`personal-account__nav__ul__item ${currentTab === 'services' && 'active'}`} onClick={() => setCurrentTab('services')}>Услуги</li>
              <li className={`personal-account__nav__ul__item ${currentTab === 'history' && 'active'}`} onClick={() => setCurrentTab('history')}>История обсуживания</li>
            </ul>

            <button className="personal-account__nav--logout">Выйти</button>
        </div>

        <div className="personal-account__content">
            {
              currentTab === 'services' && <PersonalAccountServices />
            }
            {
              currentTab === 'history' && <PersonalAccountHistory />
            }
        </div>
    </div>
  );
}
