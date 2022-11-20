import "./header.scss";

export default function Header() {
  return (
    <div className="header">
      <div className="header__top">
        <div className="header__top__info">
          <p id="header__top__name">Автотехцентр</p>
          <p id="header__top__sales">Гарантии, Скидки постоянным клиентам</p>
        </div>

        <img src="./img/logo.svg" width="178px" height="64px"></img>

        <div className="header__top__left">
          <p id="header__top__phone">+7 (343) 361-52-26</p>
          <p id="header__top__adress">г. Екатеринбург, ул. Репина, д. 32</p>
        </div>
      </div>

      <div className="header__bottom">
        <nav className="header__bottom__navigation">
          <ul className="header__bottom__navigation__list">
            <li>Главная</li>
            <li>О нас</li>
            <li>Услуги</li>
            <li>Контакты</li>
            <li>Галерея</li>
            <li>Отзывы</li>
            <li id="header_lk">Личный кабинет</li>
          </ul>
        </nav>
      </div>
    </div>
  );
}
