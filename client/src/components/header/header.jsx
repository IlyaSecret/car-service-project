import { useEffect, useRef } from "react";
import "./header.scss";
import { Link, Navigate, useNavigate, useParams } from "react-router-dom";

export default function Header() {
  const clickHandler = (position) => {
    window.scrollTo({
      top: position,
      behavior: "smooth",
    });
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
              <li id="header_lk">
                <Link to="/personal-account">Личный кабинет</Link>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  );
}
