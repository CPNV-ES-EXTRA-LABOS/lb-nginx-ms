import matplotlib.pyplot as plt
from prometheus_api_client import PrometheusConnect
from prometheus_api_client.utils import parse_datetime
import pandas as pd

prometheus_url = "http://localhost:9090"
prom = PrometheusConnect(url=prometheus_url, disable_ssl=True)

start_time = parse_datetime("20m")
end_time = parse_datetime("now")

metric_data = prom.get_metric_range_data(
    "http_server_requests_seconds_count{method='POST'}",
    start_time=start_time,
    end_time=end_time,
)

data_list = []
for result in metric_data:
    metric_labels = result['metric']
    for value in result['values']:
        timestamp = pd.to_datetime(value[0], unit='s')
        requests = float(value[1])
        data_list.append([timestamp, metric_labels.get('instance', 'unknown'), requests])

df = pd.DataFrame(data_list, columns=['timestamp', 'instance', 'requests'])
df.set_index('timestamp', inplace=True)

plt.figure(figsize=(12, 6))

for instance, group in df.groupby('instance'):
    plt.plot(group.index, group['requests'], label=f'Instance: {instance}')

plt.xlabel('Time')
plt.ylabel('Number of Requests')
plt.title('HTTP Requests Over Time')
plt.legend()
plt.grid(True)
plt.show()
