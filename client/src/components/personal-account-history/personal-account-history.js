import { useSelector } from "react-redux";
import "./personal-account-history.scss";
import HistoryRow from '../history-row/history-row';
export default function PersonalAccountHistory() {

    const works = useSelector(state => state.userData.works);
    return (
        <div className="account-history">
            <h1>История обслуживания</h1>


            <div className="account-history__table">
                <div className="account-history__table--header">
                    <p>Заказ</p>
                    <p>Машина</p>
                    <p>Исполнитель заказа</p>
                    <p>Услуга</p>
                    <p>Стоимость</p>
                    <p>Статус</p>
                </div>
                {works.map(el => <HistoryRow order={el} key={el.id}></HistoryRow>)}
            </div>
        </div>
    )
}