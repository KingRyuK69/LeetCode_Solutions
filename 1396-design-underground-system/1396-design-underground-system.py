class UndergroundSystem:

    def __init__(self):
        self.journey = {}
        self.history = {} # (startStation, stationName) => (allTime, allCount)

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.journey[id] = (stationName, t)
        

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        startStation, startTime = self.journey.pop(id)
        key = (startStation, stationName)
        allTime, allCount = self.history.get(key, (0, 0))
        self.history[key] = (allTime + (t - startTime), allCount + 1)
        

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        key = (startStation, endStation)
        allTime, allCount = self.history.get(key, (0, 0))
        return allTime / allCount