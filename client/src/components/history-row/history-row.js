import "./history-row.scss";

export default function HostoryRow({order}) {
    return (
        <div className="history-row">
            <div className="row">
                <p><span className="regular bold">{order.orderNumber}</span><br></br><span></span>{order.orderTime}</p>
                <p><span className="regular">{order.vehicle}</span> <br></br> <span className="smaill">{order.vehicleModel}</span></p>
                <p className="regular">{order.worker}</p>
                <p className="regular">{order.work}</p>
                <p className="regular">{order.price}</p>
                <p className="regular">{order.status}</p>
            </div>
            <div className="underline"></div>
            
        </div>
    )
}