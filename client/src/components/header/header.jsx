import { useEffect, useRef } from "react";
import "./header.scss";
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import Modal from "../modal/modal";
import { useDispatch, useSelector } from "react-redux";
import { AuthorizationStatus } from "../../consts";
import { getUserData } from "../../store/reducer/reducer";

export default function Header() {
  const [active, setActive] = useState(false);
  const [phoneNumber, setPhoneNumber] = useState();
  const [vehicleNumber, setVehicleNumber] = useState();
  const authStatus = useSelector((state) => state.authStatus);
  const authError = useSelector((state) => state.authError);
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const clickHandler = (position) => {
    window.scrollTo({
      top: position,
      behavior: "smooth",
    });
  };
  const onPersonalAccountClick = () => {
    if (authStatus === AuthorizationStatus.Auth) {
      navigate("/personal-account");
    } else {
      setActive(true);
    }
  };

  return (
    <div className="header">
      <div className="header__top">
        <Link to="/">
          <img src="./img/logo.svg" width="178px" height="64px"></img>
        </Link>

        <div className="header__top__left">
          <p id="header__top__phone">+7 (343) 361-52-26</p>
          <p id="header__top__adress">г. Екатеринбург, ул. Репина, д. 32</p>
        </div>
        <div className="header__bottom">
          <nav className="header__bottom__navigation">
            <ul className="header__bottom__navigation__list">
              <li>
                <button id="nav_button" onClick={() => clickHandler(890)}>
                  О нас
                </button>
              </li>
              <li>
                <button id="nav_button" onClick={() => clickHandler(1485)}>
                  Услуги
                </button>
              </li>
              <li>
                <button id="nav_button" onClick={() => clickHandler(2650)}>
                  Контакты
                </button>
              </li>
              <li>
                <button id="nav_button" onClick={() => clickHandler(3400)}>
                  Галерея
                </button>
              </li>
              <li>
                <button id="nav_button" onClick={() => clickHandler(4400)}>
                  Отзывы
                </button>
              </li>
              <li id="header_lk" onClick={onPersonalAccountClick}>
                Личный кабинет
              </li>
            </ul>
          </nav>
        </div>
      </div>
      <Modal active={active} setActive={setActive}>
        {authStatus === AuthorizationStatus.Auth ? (
          navigate("/personal-account")
        ) : (
          <div className="sign-in__modal">
            <h2>Вход</h2>
            <div className="sign-in-form__number">
              <input
                type="text"
                placeholder="Номер телефона"
                onChange={(e) => setPhoneNumber(e.target.value)}
              ></input>
            </div>
            <div className="sign-in-form__vehicle-number">
              <input
                type="text"
                placeholder="Гос. номер"
                onChange={(e) => setVehicleNumber(e.target.value)}
              ></input>
            </div>

            <button
              id="sign-in-form__button"
              onClick={() => {
                dispatch(
                  getUserData({
                    phoneNumber: phoneNumber,
                    vehicleNumber: vehicleNumber,
                  })
                );
              }}
            >
              Войти
            </button>
            {authError && (
              <span style={{ color: "red" }}>Аккаунт не найден</span>
            )}
          </div>
        )}
      </Modal>
    </div>
  );
}
