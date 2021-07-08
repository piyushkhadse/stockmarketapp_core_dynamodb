var result;
            if (logEvent.getLoggerName().includes("com.stockmarket")) {
                result = "true";
            } else if (logEvent.getMarker() != null && logEvent.getMarker().isInstanceOf("FLOW")) {
                result = "false";
            }
            result;